package others;

public class huffman_coding {
    private class HuffmanNode implements Comparable<HuffmanNode> {
        int freq;
        char c;
        HuffmanNode left,right;
        public HuffmanNode(int freq, char c){
            this.freq = freq;
            this.c = c;
            this.left = this.right = null;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            if(this.freq < o.freq){return -1;}
            else if(this.freq > o.freq){return 1;}
            else{
                return Character.compare(this.c, o.c);
            }
        }
    }
    public static void main(String[] args){

    }
}
