public class Test {
    public static void main(String[] args)throws Exception {
        AutoCompleteDictionaryTrie trieDictionary=new AutoCompleteDictionaryTrie();
        Filing file=new Filing();
        file.dict();

        for (String i : file.Dictionary){
            trieDictionary.addWord(i);
        }

        trieDictionary.FetchAll("آئر");
    }
}
