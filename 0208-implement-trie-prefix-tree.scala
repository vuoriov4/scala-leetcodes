class Trie() {

    /** Initialize your data structure here. */
    class TrieNode(val x: Char) {
        var children = Map[Char, TrieNode]()
        var last = false
    }
    
    val root = new TrieNode(0.toChar)

    /** Inserts a word into the trie. */
    def insert(word: String) {
        var current = root
        var i = 0
        while (i < word.length) {
            val c = word(i)
            if (!current.children.contains(c)) {
                current.children = current.children + (c -> new TrieNode(c))
            }
            current = current.children(c)
            i += 1   

        }
        current.last = true
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
        var current = root
        var i = 0
        while (i < word.length) {
            val c = word(i)
            if (!current.children.contains(c)) return false
            else current = current.children(c)
            i += 1   
        }
        current.last
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
        var current = root
        var i = 0
        while (i < prefix.length) {
            val c = prefix(i)
            if (!current.children.contains(c)) return false
            else current = current.children(c)
            i += 1   
        }
        true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
