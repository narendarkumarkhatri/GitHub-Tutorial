import java.util.HashMap;
import java.util.Set;
public class Node
    {
        HashMap<Character,Node> children;
        private char text;
        boolean isWord;

        public Node()
        {
            children=new HashMap<Character,Node>();
            text = ' ';
            isWord = false;
        }

        public Node(char text)
        {
            this();
            this.text = text;
        }

        public Node getChild(Character c)
        {
            return children.get(c);
        }

        public Node insert(Character c)
        {
            if (children.containsKey(c))
            {
                return null;
            }

            Node next= new Node(text);
            children.put(c,next);
            return next;
        }

        public char getText()
        {
            return text;
        }

        public void setendsWord(boolean b)
        {
            isWord=b;
        }

        public boolean endWord()
        {
            return isWord;
        }

        public Set<Character> getValidNextCharacter()
        {
            return children.keySet();
        }

    }




