package problems;


/**
 * 208. Implement Trie (Prefix Tree)
 * Medium
 * <p>
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
public class ImplementPrefixTree {

    public static class Trie {

        TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    TreeNode treeNode = new TreeNode();
                    node.children[c - 'a'] = treeNode;
                }
                node = node.children[c - 'a'];
            }
            node.setValue(word);
        }

        public boolean search(String word) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    return false;
                }
            }
            return node.value != null;
        }

        public boolean startsWith(String prefix) {
            TreeNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    return false;
                }
            }
            return node != null;
        }
    }

    public static class TreeNode {
        String value;
        TreeNode[] children;

        public TreeNode() {
            children = new TreeNode[26];// tieng anh co 26 ky tu
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("demtv");
        t.insert("mai");
        System.out.println(t.search("demtv"));
        System.out.println(t.search("mai"));
        System.out.println(t.startsWith("l"));
    }

}
