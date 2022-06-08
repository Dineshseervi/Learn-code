
/**
 * This class is provide solution for https://jira.fico.com/browse/FAWB-2941
 * Export widget not working in DMP staging and production.
 * This class set wm.studio.temp.dir property to resolve file export issue in HA
 */
public class FawbCustomTempFilesStoragePropertyLoader {

    public FawbCustomTempFilesStoragePropertyLoader() {
        System.setProperty("wm.studio.temp.dir","/app-root/runtime/data/design/");
    }
}
