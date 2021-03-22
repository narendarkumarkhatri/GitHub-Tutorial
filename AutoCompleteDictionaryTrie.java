import java.util.*;
import java.util.HashMap;

public class AutoCompleteDictionaryTrie
{
    private Node root;
    private int size;
    public String searchWord="";

    public AutoCompleteDictionaryTrie()
    {
        root = new Node();
        size=0;
    }

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    public boolean addWord(String word)
    {
        String Word=word.toLowerCase();
        if(isWord(word))
            return false;

        HashMap<Character, Node> children=root.children;
        for(int i=0; i<Word.length(); i++)
        {
            char c = Word.charAt(i);
            Node temp;
            if(children.containsKey(c))
            {
                temp = children.get(c);
            }
            else
            {
                temp = new Node((c));
                children.put(c, temp);
            }

            children = temp.children;
            if(i==Word.length()-1)
            {
                temp.isWord = true;
                size++;
            }
        }
        return true;
    }

    public int size()
    {
        return size;
    }


    public boolean isWord(String s)
    {
        Node temp = searchNode(s.toLowerCase());

        if (temp != null && temp.isWord)
            return true;
        else
            return false;
    }

    public Node searchNode(String str)
    {
        HashMap<Character, Node> children = root.children;
        Node temp = null;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (children.containsKey(c))
            {
                temp = children.get(c);
                children = temp.children;
            } else
            {
                return null;
            }
        }
        return temp;
    }


    public void FetchAll(String str)
    {
        HashMap<Character, Node> children = root.children;
        Node temp = null;

        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (children.containsKey(c))
            {
                temp = children.get(c);
                children = temp.children;
                searchWord=searchWord+temp.getText();

            } else
                {
                    System.out.println("word not found");
                    System.exit(0);
                }
        }
        getChildren(temp.children);
        
        for (int i=0;i<nodeWords.size();i++)
        {
            System.out.println(searchWord+nodeWords.get(i));
        }

    }

    String tempWord="";
    ArrayList<String> nodeWords=new ArrayList<>();

    public void getChildren(HashMap<Character,Node> children)
    {
        for (Node j : children.values())
        {////i
            tempWord=tempWord+j.getText();
            getChildren(j.children);
        }

        if(!nodeWords.contains(tempWord) && !nodeWords.equals(searchWord))
            nodeWords.add(tempWord);
        tempWord="";

    }

}









