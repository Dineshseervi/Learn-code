package main.java.basic.readwrite;

import java.io.*;

public class FileWriteReadSteamHelper {

    public void writeReadFileUsingFileStream()
    {
        String text="/*Copyright (c) 2019-2020 fico.com All Rights Reserved.\n This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance\n with the terms of the source code license agreement you entered into with fico.com*/\npackage com.basicproject_feb20.fileservice;\n\nimport com.wavemaker.runtime.WMAppContext;\nimport com.wavemaker.runtime.file.model.DownloadResponse;\nimport com.wavemaker.runtime.file.manager.FileServiceManager;\nimport com.wavemaker.runtime.util.WMRuntimeUtils;\n\nimport org.apache.commons.lang3.StringUtils;\nimport org.apache.tika.Tika;\nimport org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.web.multipart.MultipartFile;\n\nimport javax.servlet.http.HttpServletRequest;\nimport javax.annotation.PostConstruct;\nimport java.io.File;\nimport java.io.FileInputStream;\nimport java.io.IOException;\nimport java.util.ArrayList;\nimport java.util.List;\n\nimport com.wavemaker.runtime.service.annotations.ExposeToClient;\nimport org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\n\n/**\n * File service class with methods to upload, download, list and delete files.\n * This is a singleton class with all of its public methods exposed to the client via controller.\n * Their return values and parameters will be passed to the client or taken\n * from the client respectively.\n */\n@ExposeToClient\npublic class FileService {\n\n    private static final Logger logger=LoggerFactory.getLogger(FileService.class);\n\n    @Autowired\n    private FileServiceManager fileServiceManager;\n\n    private File uploadDirectory = null;\n\n    @PostConstruct\n    protected void init() {\n        uploadDirectory = getUploadDir();\n    }\n\n\n    /**\n     * *******************************************************************************\n     * INNER CLASS: WMFile\n     * DESCRIPTION:\n     * The class WMFile is a class used to represent information about a list of files.\n     * An array of WMFile objects is returned when the client asks for a list of files\n     * on the server.\n     * ********************************************************************************\n     */\n    public static class WMFile {\n        private String path;\n        private String inlinePath;\n        private String name;\n        private long size;\n        private String type;\n\n        public WMFile(String path, String inlinePath, String name, long size, String type) {\n            this.path = path;\n            this.inlinePath = inlinePath;\n            this.name = name;\n            this.size = size;\n            this.type = type;\n        }\n\n        public String getPath() {\n            return path;\n        }\n\n        public void setPath(String path) {\n            this.path = path;\n        }\n\n        public String getInlinePath() {\n            return inlinePath;\n        }\n\n        public void setInlinePath(String inlinePath) {\n            this.inlinePath = inlinePath;\n        }\n\n        public String getName() {\n            return name;\n        }\n\n        public void setName(String name) {\n            this.name = name;\n        }\n\n        public String getType() {\n            return type;\n        }\n\n        public void setType(String type) {\n            this.type = type;\n        }\n\n        public long getSize() {\n            return size;\n        }\n\n        public void setSize(long size) {\n            this.size = size;\n        }\n    }\n\n    /*\n        The class returns filepath, name , boolean success tells whether the upload was successful or not\n        and error message if the upload was not successful.\n     */\n    public static class FileUploadResponse {\n\n        private String path;\n        private String inlinePath;\n        private String fileName;\n        private long length;\n\n        private boolean success;\n        private String errorMessage;\n\n        public FileUploadResponse(String path, String inlinePath, String name, long length, boolean success, String errorMessage) {\n            this.path = path;\n            this.inlinePath = inlinePath;\n            this.fileName = name;\n            this.length = length;\n            this.success = success;\n            this.errorMessage = errorMessage;\n        }\n\n        public boolean isSuccess() {\n            return success;\n        }\n\n        public void setSuccess(boolean success) {\n            this.success = success;\n        }\n\n        public long getLength() {\n            return length;\n        }\n\n        public void setLength(int length) {\n            this.length = length;\n        }\n\n        public String getErrorMessage() {\n            return errorMessage;\n        }\n\n        public void setErrorMessage(String errorMessage) {\n            this.errorMessage = errorMessage;\n        }\n\n        public String getPath() {\n            return this.path;\n        }\n\n        public void setPath(String path) {\n            this.path = path;\n        }\n\n        public String getInlinePath() {\n            return inlinePath;\n        }\n\n        public void setInlinePath(String inlinePath) {\n            this.inlinePath = inlinePath;\n        }\n\n        public void setFileName(String fileName) {\n            this.fileName = fileName;\n        }\n\n        public String getFileName() {\n            return fileName;\n        }\n    }\n\n    /**\n     * *****************************************************************************\n     * TEMPLATE PROPERTY: uploadDir\n     * DESCRIPTION\n     * When you created your java service, you were prompted to enter a value for\n     * uploadDir.  The uploadDir is the default location to store files, and any\n     * request to delete or download files that contains a relative path will\n     * search for the file starting from uploadDir.\n     * NOTES:\n     * You can change this value at any time.\n     * You may need to set a different uploadDir for your deployment environment\n     * than you used on your local development environment.\n     * ******************************************************************************\n     */\n    protected File getUploadDir() {\n        String uploadDir = System.getProperty(\"user.home\") + \"/WaveMaker/appdata/BasicProject_Feb20/uploads\";\n        File f = new File(uploadDir);\n        f.mkdirs();\n        return f;\n    }\n\n    /**\n     * *****************************************************************************\n     * NAME: uploadFile\n     * DESCRIPTION:\n     * The FileUpload widget automatically calls this method whenever the user selects a new file.\n     * <p/>\n     * PARAMS:\n     * file : multipart file to be uploaded.\n     * relativePath : This is the relative path where file will be uploaded.\n     * <p/>\n     * RETURNS FileUploadResponse.\n     * This has the following fields\n     * Path: tells the client where the file was stored so that the client can identify the file to the server\n     * Name: tells the client what the original name of the file was so that any\n     * communications with the end user can use a filename familiar to that user.\n     * Type: returns type information to the client, based on filename extensions (.txt, .pdf, .gif, etc...)\n     * ******************************************************************************\n     */\n    public FileUploadResponse[] uploadFile(MultipartFile[] files, String relativePath, HttpServletRequest httpServletRequest) {\n        List<FileUploadResponse> wmFileList = new ArrayList<>();\n        File outputFile = null;\n        for (MultipartFile file : files) {\n            try {\n                outputFile = fileServiceManager.uploadFile(file, relativePath, uploadDirectory);\n                // Create WMFile object\n                String path = WMRuntimeUtils.getContextRelativePath(outputFile, httpServletRequest, relativePath);\n                String inlinePath = WMRuntimeUtils.getContextRelativePath(outputFile, httpServletRequest, relativePath, true);\n                wmFileList.add(new FileUploadResponse(path, inlinePath, outputFile.getName(), outputFile.length(), true, \"\"));\n            } catch (Exception e) {\n            \tlogger.warn(\"Failed to uplaod file {}\", file.getName(), e);\n                wmFileList.add(new FileUploadResponse(null, null, file.getOriginalFilename(), 0, false, e.getMessage()));\n            }\n        }\n        return wmFileList.toArray(new FileUploadResponse[wmFileList.size()]);\n    }\n\n\n    /**\n     * *****************************************************************************\n     * NAME: listFiles\n     * DESCRIPTION:\n     * Returns a description of every file in the uploadDir.\n     * RETURNS array of inner class WMFile (defined above)\n     * ******************************************************************************\n     */\n    public WMFile[] listFiles(HttpServletRequest httpServletRequest, String relativePath) throws IOException {\n        Tika tika = new Tika();\n        File[] files = fileServiceManager.listFiles(uploadDirectory, relativePath);\n\n              /* Iterate over every file, creating a WMFile object to be returned */\n        WMFile[] result = new WMFile[files.length];\n        for (int i = 0; i < files.length; i++) {\n            String filteredPath = WMRuntimeUtils.getContextRelativePath(files[i], httpServletRequest, relativePath);\n            String inlinePath = WMRuntimeUtils.getContextRelativePath(files[i], httpServletRequest, relativePath, true);\n            result[i] = new WMFile(filteredPath, inlinePath, files[i].getName(), files[i].length(), tika.detect(files[i]));\n        }\n        return result;\n    }\n\n    /**\n     * *****************************************************************************\n     * NAME: deleteFile\n     * DESCRIPTION:\n     * Deletes the files with the given path or name.  If the parameters are just file\n     * names, it will look for files of that name in the uploadDir.  If its a full path\n     * will delete the file at that path IF that path is within the uploadDir.\n     * RETURNS boolean to indicate if success or failure of operation.\n     * **************************************************************************\n     */\n    public boolean deleteFile(String file, String relativePath) throws IOException {\n        return fileServiceManager.deleteFile(file, relativePath, uploadDirectory);\n    }\n\n    /**\n     * *****************************************************************************\n     * NAME: downloadFile\n     * DESCRIPTION:\n     * The specified file will be downloaded to the user's computer.\n     * - file: filename (if the file is in uploadDir) or path\n     * - relativePath: relativePath in the uploadDirectory\n     * - returnName: Optional string; if used, then this is the name that the user will see\n     * for the downloaded file.  Else its name matches whats on the server.\n     * RETURNS DownloadResponse instance\n     * **************************************************************************\n     */\n    public DownloadResponse getDownloadFile(String file, String relativePath, String returnName) throws Exception {\n        return downloadFile(file, relativePath, returnName, false);\n    }\n\n    /**\n     * *****************************************************************************\n     * NAME: getDownloadFileAsInline\n     * DESCRIPTION:\n     * The specified file will be downloaded to the user's computer.\n     * - file: filename (if the file is in uploadDir) or path\n     * - relativePath: relativePath in the uploadDirectory\n     * - returnName: Optional string; if used, then this is the name that the user will see\n     * for the downloaded file.  Else its name matches whats on the server.\n     * RETURNS DownloadResponse instance\n     * **************************************************************************\n     */\n    public DownloadResponse getDownloadFileAsInline(String file, String relativePath, String returnName) throws Exception {\n        return downloadFile(file, relativePath, returnName, true);\n    }\n\n    private DownloadResponse downloadFile(String file, String relativePath, String returnName, boolean inline) throws Exception {\n        File f = fileServiceManager.downloadFile(file, relativePath, uploadDirectory);\n        returnName = (returnName != null && returnName.length() > 0) ? returnName : f.getName();\n\n        // Create our return object and setup its properties\n        DownloadResponse downloadResponse = new DownloadResponse();\n\n        // Setup the DownloadResponse\n        FileInputStream fis = new FileInputStream(f);\n        downloadResponse.setContents(fis);\n        downloadResponse.setInline(inline);\n        downloadResponse.setFileName(returnName);\n        return downloadResponse;\n    }\n}";

        System.out.println(text);
        byte [] bytearray=text.getBytes();
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("FileService.java",true);
            try {
                fileOutputStream.write(bytearray);
                //fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File file=new File("text2.txt");
            FileInputStream fileInputStream=new FileInputStream(file);
            //fileInputStream.read();
            int i=0;
            while((i=fileInputStream.read())!=-1)
            {
                System.out.print((char)i);
            }
fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWrite()
    {
        byte [] bytelength=null;
        try {
            File file=new File("testfile.xlsx");
            String filePath=file.getAbsolutePath();
            String fileName=filePath.substring(filePath.lastIndexOf("/")+1);;
            FileInputStream fileInputStream=new FileInputStream(file);
            System.out.println("{\"expiration\":3600,\"policies\":[{\"paths\":[\"/\"],\"permissions\":[\"read\",\"write\",\"list\",\"delete\"]}]}");
            //fileInputStream.read();
            bytelength=new byte[(int)(file.length())];
            int i=0;
            fileInputStream.read(bytelength);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileOutputStream fileOutputStream=new FileOutputStream("testfile_output.xlsx");
            try {
                fileOutputStream.write(bytelength);
                //fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FileWriteReadSteamHelper fileWriteReadSteamHelper=new FileWriteReadSteamHelper();
        fileWriteReadSteamHelper.readWrite();
    }
}
