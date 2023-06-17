public class Trie {
    static final int ALPHABET_SIZE = 26;
    public static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        public TrieNode(){
            isEndOfWord = false;
            for(int i=0;i<ALPHABET_SIZE;i++)
                children[i] = null;
        }
    }
    public static TrieNode root;
    static void insert(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode curr = root;
        for(level = 0;level<length;level++){
            index = key.charAt(level)-'a';
            if(curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    public static boolean find(String key){
        int level;
        int index;
        int length = key.length();
        TrieNode curr = root;
        for(level = 0;level<length;level++){
            index = key.charAt(level)-'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        if(curr.isEndOfWord)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};
        root = new TrieNode();

        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
        if(find("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
    }
}
