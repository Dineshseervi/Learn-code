package main.java.CollectionsExample.set.example;

import java.util.*;

public class LongestStringChain {

  /*  Map<String,Integer> memoryMap=new HashMap<>();
    public int longestStrChain(String[] words) {
        int count=0;
        Arrays.sort(words, (a,b)->a.length()-b.length());

        Map<Integer, List<String>> map=new HashMap<>();

        for(int i=0;i<words.length;i++)
        {
            int len=words[i].length();
            if(map.containsKey(len))
            {
                List<String> list=map.get(len);
                list.add(words[i]);
                map.put(len,list);
            }else{
                List<String> list=new ArrayList<>();
                list.add(words[i]);
                map.put(len,list);
            }
        }

        for(int i=0;i<words.length-1;i++)
        {
            String current_word=words[i];
            int num=dfs(current_word,map);
            count=Math.max(num,count);
        }
        return count+1;

    }

    private int dfs(String word,Map<Integer,List<String>> map)
    {
        int ll=0;
        Integer len=word.length();
        List<String> list= (map.get(len + 1));
        if(list==null)
        {
            return ll;
        }
        for(String ww:list)
        {
            if(checkWord(word,ww))
            {
                int num=0;
                if(memoryMap.containsKey(ww))
                {
                    num=memoryMap.get(ww);
                }else {
                     num = dfs(ww, map) + 1;
                     memoryMap.put(ww,num);
                }
               ll= Math.max(num,ll);
            }
        }
        return ll;
    }

    private boolean checkWord(String cw,String nw)
    {
        if(cw.length()+1 == nw.length())
        {
            int count=0;

            boolean extraWord=false;
            for(int i=0;i<cw.length();i++)
            {
                if(!nw.contains(cw.charAt(i)+""))
                {
                    return false;
                }

                if(!extraWord)
                {
                    if(cw.charAt(i)!=nw.charAt(i))
                    {
                        extraWord=true;
                        if(cw.charAt(i)!=nw.charAt(i+1))
                        {
                            return false;
                        }
                    }
                }else{
                    if(cw.charAt(i)!=nw.charAt(i+1))
                    {
                        return false;
                    }
                }
            }
            *//*
            boolean extraWord=false;
            for(int i=0;i<cw.length();i++)
            {
                if(!extraWord)
                {
                    if(cw.charAt(i)!=nw.charAt(i))
                    {
                        extraWord=true;
                        if(cw.charAt(i)!=nw.charAt(i+1))
                        {
                            return false;
                        }
                    }
                }else{
                    if(cw.charAt(i)!=nw.charAt(i+1))
                    {
                        return false;
                    }
                }
            }*//*
            return true;
        }
        return false;
    }*/

    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String word : words) {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
    public static void main(String[] args) {

        LongestStringChain longestStringChain=new LongestStringChain();
        long start=System.currentTimeMillis();
        //int val=longestStringChain.longestStrChain(new String[]{"klmnowx","abcdefgiklmno","fgij","bcfghijklmno","fgjpqrst","uy","abceklmnouvw","pqrstuwy","fghijlno","mnouvwxy","klmnopqt","klmnopqrstuy","aeuvw","muvw","abcdeklmnow","fhijpqrst","mpqrst","klmnoprt","fghijklno","abcdelmo","klnuvwxy","klmnopst","abcdeklmnov","fghj","luvwxy","ghklmnopqrst","pqrstwx","abcdklmno","cdefghij","pqrs","efghijklmno","fghjklmno","adeklmno","rs","kuvwxy","ghij","befghijklmno","ln","hijklmnopqrst","ghpqrst","fgiklmnopqrst","pqrtuvwxy","pqrsty","jklmnopqrst","lnouvwxy","klmnoqsuvwxy","abcdeghklmno","fi","fghijlnpqrst","abdklmnouvw","uwx","abcdekln","klmno","abcdekn","abcdemuvw","pqs","fghijpqt","klmnopqrstuw","n","nopqrstuvwxy","abcdefghj","fghiklmnopqrst","klmnorst","abcdemnouvw","fgh","pqt","abfghij","o","nouvw","abcdklmnouvw","abeklmno","abcden","klmnopqrstwxy","q","fghijklmnoprt","klmnovx","abceuvw","klmnopsuvwxy","hj","abcdefgh","fhjklmno","klmnoquvwxy","wxy","klmnopqrstuvwy","kln","abcdegklmno","mno","gklmno","klnouvw","fghijklmnoqr","fghijpqrst","mnuvwxy","ghipqrst","klmnoqrtuvwxy","acdfghij","uwy","fghjklmnopqrst","mnpqrstuvwxy","abcdeknouvw","abcdefghijklmno","klmnorsuvwxy","abcdeh","klmnost","iklmnopqrst","abcdegijklmno","fghijklmopqrst","fghijklmnors","pqrstux","abcdefghijlm","abcdem","klmn","opqrst","ghjklmnopqrst","cdfghij","kluvwxy","ceklmno","abcdeghijklmno","lmo","bklmno","fghijs","cdeklmnouvw","abcdeknuvw","cdklmnouvw","abcdeklmnovw","klmnopr","fghijklmnopqrst","klmnopqtuvwxy","abcdefhijklmno","abcdeuv","abcdefhklmno","x","abcdeouvw","fjklmno","a","klmnopqrstuv","abdklmno","fghijlm","bcefghijklmno","quvwxy","fghi","klmnopqrstuwx","r","klmnuvw","kn","abcdeklmn","abcdeklmno","ps","klmnoqrt","pstuvwxy","klmnopqrsty","lmn","d","abcdefghijmo","fghijmnopqrst","ghiklmno","mouvwxy","abcdeghj","fghijklmnopr","kmnouvwxy","fghijklmnopqst","klmnox","nouvwxy","adefghijklmno","kmo","klmnovy","klmnopqrstuvwxy","cde","y","klmnouy","fgklmnopqrst","nuvwxy","kluvw","abcdefghijkno","abcdekl","fghijno","ceuvw","abcdelo","bcdklmno","gij","abcdeijklmno","klmnopqrt","abcdeklm","pqruvwxy","klnuvw","fijklmno","knpqrstuvwxy","fghijklmnor","ace","abcdekluvw","deklmnouvw","lpqrstuvwxy","abcdefhiklmno","fijpqrst","klmnopqrstvwy","mn","kmpqrst","ipqrst","fghijkmnpqrst","uvxy","bklmnouvw","fghijkmnopqrst","fghijklnopqrst","kopqrstuvwxy","pqrstuwxy","abdeuvw","acefghij","jklmno","k","fghijqs","abcdefghijno","fghijklmnort","adeuvw","vwx","gjklmno","hi","abcdefghijm","nuvw","fklmnopqrst","abcdehklmno","fghijklmnoqrt","klmnoruvwxy","abcdemnuvw","klmnovw","klmnopqrstvw","klmnoqtuvwxy","klmnoy","wx","ouvwxy","lmopqrst","fghjpqrst","lnuvwxy","vy","abdfghijklmno","kmnouvw","uvy","klmnoqst","klmnort","pqrstuxy","qs","lopqrstuvwxy","mnouvw","abdeklmno","abcdelnouvw","pruvwxy","qrsuvwxy","cklmno","bc","acdfghijklmno","j","fghijpqs","fghijknopqrst","fgijklmno","fghijnopqrst","mpqrstuvwxy","knopqrst","acdeuvw","lnouvw","fghijklmn","klmnouvxy","abcdefghiklmno","abcdefghij","hij","abcdekuvw","klmnopqs","aklmnouvw","acdefghijklmno","cfghij","fghijpqst","cfghijklmno","abcdefhi","kmouvwxy","pquvwxy","pqrstuy","pqrstuwx","ce","klmnopqrstv","deklmno","klmnouvw","abcdeno","fghijkmo","knouvwxy","fpqrst","hklmno","fghijkmopqrst","abcdefghjklmno","kmpqrstuvwxy","dklmnouvw","abcdefghijkmo","abcdel","giklmnopqrst","buvw","klmo","klmnoqrsuvwxy","uvwy","abcdeluvw","klmnostuvwxy","bceklmno","fghijm","defghijklmno","ijklmno","pqr","abcduvw","fghijklmnopqt","hijklmno","klmnoprsuvwxy","aeklmno","lo","klmnouxy","cdklmno","fghijpr","muvwxy","lmnouvwxy","abce","kmnopqrst","pt","klmnoptuvwxy","abde","abcdeghiklmno","klmnopqsuvwxy","klmnouvx","efghij","klmnouwy","bceklmnouvw","klmnuvwxy","ad","klmnoux","gjpqrst","abcdegij","fghijkpqrst","fghijlmnopqrst","abcdefj","fghijklmnops","fghijklmnoqs","ghi","fghijqst","abcdemo","abcdefghijkl","fghklmnopqrst","no","klmnopqrstuwxy","klmnopqrstvwx","abcdeklmnou","abdefghijklmno","klmnopqrstxy","acfghij","pqrstuvwy","kuvw","abcdehi","de","fghijpq","lmuvwxy","abcdelmouvw","abdfghij","knuvwxy","acde","cuvw","uw","kmopqrstuvwxy","abcfghij","fghij","abcdeklmo","abcdehij","abcdek","fghijklmnoqrst","pqrstvx","klmnopqrstvx","abc","klmnoqrstuvwxy","acklmnouvw","afghijklmno","abcdeklmnuvw","abcdei","fgiklmno","klmnopqrstuvw","abcklmnouvw","abcdelmnuvw","abcdehj","abcdefghijlo","fghpqrst","acfghijklmno","abcdeg","klpqrst","klmouvw","bdfghijklmno","aefghijklmno","fijklmnopqrst","fghijps","fghijklnpqrst","fghijklmnop","fklmno","klmnopqrstw","abcdfghijklmno","fj","lnopqrst","fghijkmpqrst","fghijlnopqrst","ux","fgjklmno","fghijklmnopqr","abcdeghjklmno","abcdefghijkmn","abcdegiklmno","abcdefiklmno","acdeklmno","klmnops","fghijklmnopqrt","fghijklmnoqt","abcdegj","acdklmno","abcdeghi","abcdelmuvw","abcdefg","fghijkl","gjklmnopqrst","hipqrst","klmnopqstuvwxy","lnuvw","ghijpqrst","pqrstuvwxy","klmnovwx","klmnoqstuvwxy","bcklmnouvw","abdeklmnouvw","fghijklmnopq","abcdefghijk","abcdefghijklno","fiklmnopqrst","klmnopq","npqrstuvwxy","klmnopqrstwx","abcdefi","lpqrst","ghijklmnopqrst","bd","bcuvw","hjklmnopqrst","adfghijklmno","klmnosuvwxy","louvwxy","bce","gpqrst","fghijklmnot","wy","pqrstvwxy","fghijkln","lmouvw","gi","fghijn","fhklmnopqrst","ghj","klpqrstuvwxy","abcdefgklmno","fghijlmo","fghijo","fhpqrst","klmnoprs","abcefghij","abcdeklno","abcdefghijlmno","kmnpqrst","fghijklmnoq","abcdefhij","fghijklmnopt","klmnopt","abcdefklmno","abcdelno","pqrstw","fghijlopqrst","bfghij","abuvw","abcdefghijln","ac","aefghij","prs","lmnopqrstuvwxy","abcdefghijn","klmnopqrstux","luvw","giklmno","kpqrst","jpqrst","fghijrt","fghijlo","abcdefij","fghijklmnorst","fghijqrst","tuvwxy","fghijlmopqrst","klmnouwxy","bdeuvw","fghijprt","klmnoprst","pqrstuvy","fghijpqrt","fgj","pqrstvxy","abdefghij","abcdegh","abefghij","lno","klmnopuvwxy","klmnouvwxy","fghijrst","cd","euvw","hijpqrst","pqrst","klopqrst","gijpqrst","klmnopqrs","fghijk","klopqrstuvwxy","rtuvwxy","klmnorstuvwxy","stuvwxy","abcdevw","cdefghijklmno","bdeklmno","pqstuvwxy","fghipqrst","fghijpst","kmn","mo","abcdeuw","qst","fghijklmnost","klnopqrst","abcdekm","abcdefgj","klmnopqrstuvy","kouvw","abcdelmnouvw","abefghijklmno","fgipqrst","klm","klmnopstuvwxy","abcdekmno","fghijmno","pqrstvw","kmouvw","cdeklmno","st","fij","fhiklmno","abcdefghklmno","lmnuvwxy","klmnovwy","klmnow","mnuvw","fghijklmnpqrst","klmnoxy","fghklmno","b","lopqrst","pqrstuvw","abcdekmouvw","abcdeklmnouw","acduvw","klmnoq","bde","pqrstxy","qrs","bcdeklmnouvw","abcdekmo","abcdefghijkn","kno","abcdefghijklm","abcdefgij","kmopqrst","kmnuvwxy","pqrstuvwx","fghijkmn","acdefghij","fghijmn","qr","l","kmnopqrstuvwxy","abcdefghijl","afghij","auvw","abcdew","klmnopqrstwy","adfghij","abcdeghij","lmopqrstuvwxy","abcdefghijklmn","uvx","km","abcdefijklmno","abcdeij","pq","lnpqrst","bdfghij","abcdefhj","mopqrstuvwxy","fghijklmnopqs","fghijqt","ade","abcdejklmno","fghijklmpqrst","pqrstuvxy","mouvw","mopqrst","lmnopqrst","abcdefhjklmno","acdklmnouvw","bcklmno","nopqrst","qrt","fghijlmnpqrst","pqrstuv","klmnos","pqrstwxy","fgjklmnopqrst","pqrstuw","klmnopqrstuvxy","fhijklmno","abcdekmnuvw","ghjklmno","klmnoprtuvwxy","abcdefghijlmn","klmouvwxy","abcdegjklmno","p","hiklmnopqrst","rstuvwxy","gh","cdfghijklmno","klmnou","iklmno","klmnopqrstvxy","lmpqrstuvwxy","prtuvwxy","klmnovwxy","pqst","klmnortuvwxy","lmnpqrstuvwxy","fghijmpqrst","ghiklmnopqrst","klmpqrst","klmnoprstuvwxy","ghklmno","fghijopqrst","klmnoqruvwxy","abcdeklmouvw","ae","abcfghijklmno","vw","fghijr","kmnpqrstuvwxy","fghijklpqrst","vwxy","uxy","cklmnouvw","abcdefghijkm","uvw","bcd","bcefghij","abcdeiklmno","klmnot","cduvw","fghijmo","eklmnouvw","klmnopqrstuwy","kmnuvw","lmouvwxy","abcdefghijlmo","cefghij","klmnoqs","klmnouwx","kmuvwxy","ceklmnouvw","fghijklmnoqrs","abduvw","abceklmno","ghijklmno","abcdefghijmn","bcdfghij","pqrstvwx","fghijlpqrst","gijklmnopqrst","abcdelnuvw","pqrstvwy","pr","fghijklmnos","c","fghijklmno","abcdefghijkmno","abcuvw","abcdev","abeuvw","pqrstuvx","klo","fghijln","klmnpqrstuvwxy","abcdefghijlno","fghijklmnopst","acd","gipqrst","w","abcdenuvw","deuvw","abcdeklmnouvw","fg","cdeuvw","lmnuvw","abcdenouvw","klmnoqt","hklmnopqrst","klmnouvwy","gijklmno","klmnopqrst","fghijmopqrst","kmno","f","uv","fhij","knuvw","klmnor","klnouvwxy","bcdeuvw","bdklmno","abklmnouvw","abcdehjklmno","bcde","fghijklmo","abcdefghijklmo","ko","abcdeklmuvw","bcdefghijklmno","beuvw","qstuvwxy","aeklmnouvw","h","t","kmuvw","fhi","fjklmnopqrst","hiklmno","fhipqrst","qrtuvwxy","abcdeklnuvw","fghijqrt","pqrstx","bdefghijklmno","gj","abcdelmno","abcdefjklmno","fhjpqrst","klnpqrst","fgijklmnopqrst","abcdelm","fghijrs","klmnouw","fhklmno","abcdeln","fgijpqrst","fghijklmnoqst","abeklmnouvw","klmuvw","i","lmno","fghijklo","fghijkm","g","adklmnouvw","be","abcdefgjklmno","prst","puvwxy","qrstuvwxy","klmnov","klmnopqrstuvwx","acefghijklmno","fghijpqrs","fhj","abklmno","abcd","fiklmno","ijpqrst","fghijnpqrst","lmnouvw","suvwxy","knouvw","duvw","fghijkmno","bdefghij","aceklmno","fgklmno","fghijst","adefghij","fghijklmnopqrs","bcdefghij","abcdefghijko","klmnotuvwxy","klmnopruvwxy","klmnovxy","qtuvwxy","fhjklmnopqrst","klmnoqrst","prt","fghijt","uvwx","abcdekmnouvw","dfghij","abcdehiklmno","klmnopqrstu","adeklmnouvw","abcdefghijmno","klmnopquvwxy","abcdefghijkln","mnpqrst","fghijlmn","lnopqrstuvwxy","pqrt","fghijpt","abcde","ij","bcdklmnouvw","fghijkn","pst","bdklmnouvw","abcdeko","fh","fjpqrst","fghijqr","beklmno","fghijklopqrst","lmuvw","klouvw","fghijpqr","abcdegi","psuvwxy","klnopqrstuvwxy","abcdelmn","fhiklmnopqrst","fghijprst","lnpqrstuvwxy","qruvwxy","aduvw","abcdekmuvw","adklmno","abcdeu","cefghijklmno","lm","hjklmno","abcdefghijklo","klmnoqrs","fghijko","ouvw","pqrstu","mnopqrst","louvw","prsuvwxy","abcdekno","klmnopqruvwxy","kpqrstuvwxy","abcdefgijklmno","klmnors","abcdefghijo","npqrst","knopqrstuvwxy","vx","fghijqrs","klmnopqrstuxy","u","aceuvw","klmnopqrtuvwxy","uvwxy","fipqrst","klmnowxy","befghij","gklmnopqrst","abe","mnopqrstuvwxy","fghijklmnoprs","abcdeo","eklmno","fgi","fghijlmpqrst","qt","abcdefghi","bcduvw","bduvw","klouvwxy","kouvwxy","fghiklmno","abcdemno","pqsuvwxy","ab","klmnopqrstvwxy","pqrstv","abfghijklmno","beklmnouvw","fghijklm","pqrsuvwxy","acdeklmnouvw","vwy","ghjpqrst","fghijl","klmnopqrstvy","abcdelouvw","fhijklmnopqrst","klmpqrstuvwxy","abcdef","bcfghij","fghijkno","kopqrst","rsuvwxy","abcdekmn","aklmno","dfghijklmno","abcdeklouvw","klmnpqrst","abcdeklmnouv","knpqrst","aceklmnouvw","kl","fghijprs","rt","klmnopqrsuvwxy","bfghijklmno","klmnouv","abcdefh","s","klmnouvwx","fghijp","uwxy","fghijq","klmnoqr","vxy","fgpqrst","fghijlmno","defghij","pqtuvwxy","dklmno","klno","klmnowy","abcdemn","abcdeklnouvw","ptuvwxy","abcdehijklmno","acuvw","bcdfghijklmno","abcdemouvw","abcdefgi","opqrstuvwxy","v","lmpqrst","abcdeuvw","abcdekouvw","qrst","klmopqrstuvwxy","prstuvwxy","lmnpqrst","pqrstvy","abcdfghij","klmnop","ijklmnopqrst","klnpqrstuvwxy","klmnopqr","xy","abcdeklo","abd","klmnouvy","klmuvwxy","abcefghijklmno","fghijkopqrst","fghijklmnoprst","ruvwxy","m","e","abcdej","hpqrst","bceuvw","fghijmnpqrst","pqrstwy","klmnopqrstx","qsuvwxy","fghijknpqrst","bcdeklmno","klmopqrst","bdeklmnouvw","klmnopqst","klmnopqrstuvx","acklmno","hjpqrst","abcklmno","rst"});
        int val=longestStringChain.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"});
        System.out.println("val:"+val);
        System.out.println("time :"+(System.currentTimeMillis()-start));
    }
}
