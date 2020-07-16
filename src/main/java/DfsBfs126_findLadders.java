import java.util.*;

public class DfsBfs126_findLadders {
    List<List<String>> res = new ArrayList<>();
    Map<String, HashSet<String>> pattern2strs = new HashMap<>();
    HashMap<String, List<String>> leftEndWord2list = new HashMap<>();
    HashMap<String, List<String>> rightEndWord2list = new HashMap<>();
    Integer minSize = null;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
            for (String pattern : getPatterns(word)) {
                HashSet<String> strings = pattern2strs.get(pattern);
                if (strings == null) {
                    strings = new HashSet<>();
                    pattern2strs.put(pattern, strings);
                }
                strings.add(word);
            }
        }
        if (!dict.contains(endWord)) {
            return res;
        }

        HashSet<String> visitedLeft = new HashSet<>();
        LinkedList<String> leftQ = new LinkedList<>();
        leftQ.add(beginWord);
        visitedLeft.add(beginWord);
        leftEndWord2list.put(beginWord, Arrays.asList(beginWord));

        HashSet<String> visitedRight = new HashSet<>();
        LinkedList<String> rightQ = new LinkedList<>();
        rightQ.add(endWord);
        visitedRight.add(endWord);
        rightEndWord2list.put(endWord, Arrays.asList(endWord));

        boolean hasFind = false;
        outer:
        while (!leftQ.isEmpty() || !rightQ.isEmpty()) {
            int sizeLeft = leftQ.size();
            for (int i = 0; i < sizeLeft; i++) {
                String strLeft = leftQ.poll();
                List<String> list = leftEndWord2list.get(strLeft);
                for (String nextWord : getNextWords(strLeft)) {
                    if (visitedRight.contains(nextWord)) {
                        List<String> temp = new ArrayList<>();
                        temp.addAll(rightEndWord2list.get(nextWord));
                        List<String> leftList = leftEndWord2list.get(strLeft);
                        for (int k = leftList.size() - 1; k >= 0; k--) {
                            temp.add(leftList.get(k));
                        }
                        if (minSize == null || minSize == temp.size()) {
                            Collections.reverse(temp);
                            res.add(temp);
                            minSize = temp.size();
                            hasFind = true;
                        } else {
                            break outer;
                        }
                    } else if (!visitedLeft.contains(nextWord)) {
                        visitedLeft.add(nextWord);
                        leftQ.addLast(nextWord);
                        ArrayList<String> newList = new ArrayList<>(list);
                        newList.add(nextWord);
                        leftEndWord2list.put(nextWord, newList);
                    }
                }
            }

            int sizeRight = rightQ.size();
            for (int i = 0; i < sizeRight; i++) {
                String strRight = rightQ.poll();
                List<String> list = rightEndWord2list.get(strRight);
                for (String nextWord : getNextWords(strRight)) {
                    if (visitedLeft.contains(nextWord)) {
                        List<String> temp = new ArrayList<>();
                        temp.addAll(leftEndWord2list.get(nextWord));
                        List<String> rightList = rightEndWord2list.get(strRight);
                        for (int k = rightList.size() - 1; k >= 0; k--) {
                            temp.add(rightList.get(k));
                        }
                        if (minSize == null || minSize == temp.size()) {
                            res.add(temp);
                            minSize = temp.size();
                            hasFind = true;
                        } else {
                            break outer;
                        }
                    } else if (!visitedRight.contains(nextWord)) {
                        visitedRight.add(nextWord);
                        rightQ.addLast(nextWord);
                        ArrayList<String> newList = new ArrayList<>(list);
                        newList.add(nextWord);
                        rightEndWord2list.put(nextWord, newList);
                    }
                }
            }
            if (hasFind) break outer;
        }
        return res;
    }

    private HashSet<String> getNextWords(String s) {
        HashSet<String> res = new HashSet<>();
        for (String pattern : getPatterns(s)) {
            HashSet<String> strings = pattern2strs.get(pattern);
            if (strings == null) continue;
            for (String str : strings) {
                res.add(str);
            }
        }
        res.remove(s);
        return res;
    }

    private List<String> getPatterns(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char temp = cs[i];
            cs[i] = '*';
            res.add(new String(cs));
            cs[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
//        Object o = new DfsBfs126_findLadders().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        Object o = new DfsBfs126_findLadders().findLadders("lost", "cost", Arrays.asList("most","fist","lost","cost","fish"));
        Object o = new DfsBfs126_findLadders().findLadders("cet", "ism", Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"));
        System.out.println(o);
    }
}