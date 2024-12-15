
public class Main {
        public static void main(String[] arg) {
                DirectedGraph dg = new DirectedGraph();
                dg.addNode("A");
                dg.addNode("B");
                dg.addNode("C");
                String[] nodes = { "A", "B", "C", "D", "E", "F", "G" };
                dg.addNodeAll(nodes);
                String[][] edges = { { "A", "B" }, { "B", "E" }, { "B", "C" }, { "C", "D" }, { "C", "F" },
                                { "F", "G" } };
                dg.addEdgeAll(edges);
                System.out.println("This is how the graph looks like!");
                dg.print();
                System.out.println("It's breadth first search");
                dg.bfs();
                System.out.println("It's depth first search");
                dg.dfs();
                // ----------------------------------------------------------------------------------
                // BinarySearchTree<Integer> bst = new BinarySearchTree<>();
                // Integer[] treeNodes = { 20, 40, 9, 7, 15, 25, 45, 41, 23, 31, 100 };
                // bst.insertListOfNodes(treeNodes);
                // System.out.println(bst.search(15));
                // System.out.println(bst.search(100));
                // System.out.println(bst.search(1000));
                // bst.delete(40);
                // bst.preorder(bst.root);
                // System.out.println("");
                // ------------------------------------------------------------------------------------

                // CircularQueue<Integer> cQ = new CircularQueue<>();
                // cQ.enQueue(1);
                // cQ.enQueue(2);
                // cQ.enQueue(3);
                // cQ.enQueue(4);
                // System.out.println(cQ);

                // DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
                // dl.push(1);
                // dl.push(2);
                // dl.push(3);
                // dl.push(4);
                // System.out.println(dl);

                // CircularLinkeList<Integer> cl = new CircularLinkeList<>();
                // cl.push(1);
                // cl.push(2);
                // cl.push(3);
                // cl.push(4);
                // cl.pop();
                // System.out.println(cl);

                // Solution so = new Solution();
                // int[] gas = {1,2,3,4,5};
                // int[] gas2 = {2,3,4};

                // int[] cost = {1,2,3,4,5};
                // int[] cost2 = {3,4,3};
                // so.canCompleteCircuit(gas2, cost2);

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                // stack_problems sp1 = new stack_problems();

                // PROBLEM - 1
                // Stack<Integer> s1 = new Stack<>();
                // s1.push(1);
                // s1.push(2);
                // s1.push(3);
                // s1.push(4);
                // s1.push(5);
                // s1.push(6);
                // s1.push(7);
                // s1.push(8);
                // s1.push(9);
                // s1.push(10);
                // int[] arr = { 6, 10, 9, 8, 7, 3, 4, 5, 2, 1 };
                // sp1.prob1(s1, arr);

                // PROBLEM 2

                // sp1.prob2();

                // PROBLEM 3

                // System.out.println(sp1.prob3("[()]{}{[()()]()}"));

                // PROBLEM 4

                // sp1.prob4("245+*");
                // sp1.prob4("87-24^*");

                // PROBLEM 5

                // Stack<Integer> s1 = new Stack<>();
                // s1.push(1);
                // s1.push(4);
                // s1.push(3);
                // s1.push(2);
                // s1.push(2);
                // s1.push(5);
                // s1.push(5);
                // System.out.println(sp1.prob5(s1));

                ///////////////////////////////////////////////////////////////////////////////////////////////////////

                // twodarrays_strings_2 twod = new twodarrays_strings_2();
                // PROBLEM 1

                // int[][] arr = { { 1, 2, 3, 4 }, { 5, 1, 6, 3 }, { 9, 5, 1, 2 } };
                // twod.prob1(arr);

                // PROBLEM 3
                // int[][] arr = {{1,2,3,4},{5,6,7,8}};
                // twod.prob3(4,2,arr);

                // PROBLEM 4
                // twod.prob4("599642");

                // PROBLEM 5
                // twod.prob5();

                ////////////////////////////////////////////////////////////////////////////////////
                // problems4 p = new problems4();

                // PROBLEM 1

                // ArrayList<Integer> l = new ArrayList<Integer>();
                // l.add(100);
                // l.add(200);
                // l.add(31);
                // l.add(13);
                // l.add(97);
                // l.add(10);
                // l.add(20);
                // l.add(11);
                // p.prob1(l);

                // PROBLEM 2

                // int[] arr = {1,2,3,4,5,6,7,8};
                // int len=8,k=4;
                // p.prob2(len, k, arr);

                // PROBLEM 3

                // prob3(new int[]{1, 2, 3, 4, 5, 4, 9, 0});

                // int[] arr = { 1, 5, 3, 8, 2, 4, 7, 6, 9 };
                // int k = 5;
                // p.prob4(arr, k);

                // PROBLEM 5
                // int[] arr = {1,0,0,2,1,0,2,2};
                // p.prob5(arr);

                // PROBLEM 6

                // int[] arr = {1,2,-2,10,-16,77,0,-55};
                // p.prob6(arr);

                // PROBLEM 7

                // p.prob7("Good to see you today!");
                // p.prob7ii("nice");

                // PROBLEM 8

                // p.prob8("GooD");

                // PROBLEM 9
                // p.prob9("You are interested in programming");

                // PROBLEM 10
                // p.prob10(4, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

                ////////////////////////////////////////////////////////////////////////////////////////////////
                // twodarrays twoD = new twodarrays();

                // PROBLEM 1
                // int[][] arr = {{1,2,3},{0,1,0},{0,0,0}};
                // twoD.prob1(arr);

                // PROBLEM 2
                // int[][] arr = {{6,4,6,9},{2,6,1,8},{5,5,2,2},{4,4,1,3}};
                // twoD.prob2(arr);

                // PROBLEM 3

                // int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
                // 15, 16 } };
                // twoD.prob3(arr);

                // PROBLEM 4

                // int[][] arr3 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 15, 14, 15
                // }, { 16, 17, 18, 19, 20 },
                // { 21, 22, 23, 24, 25 } };
                // System.out.println(twoD.prob4(arr3, 30));

                // PROBLEM 5
                // int[][] arr1 = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
                // int[][] arr2 = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10,
                // 9, 8, 7 } };
                // int[][] arr3 = { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20,
                // 7 }, { 14, 23, 22, 21, 8 },
                // { 13, 12, 11, 10, 9 } };
                // twoD.prob5(arr1);

        }
}