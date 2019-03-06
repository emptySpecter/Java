public class Main6 {

    public static void main(String[] args) {
        int countBalanced = 0;
        int numberTrees = 200;
        int numberAddedTrees = 30;
        int lengthOfDio = 42;
        int offSet = 21;
        for (int i = 0; i < numberTrees; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < numberAddedTrees; j++) {
                tree.add((int)(Math.random()*lengthOfDio-offSet));//Kono DIO da

            }
            if(tree.isBalanced(tree.getRootNode())) countBalanced++;
            tree = null;
        }
        System.out.println("Percent of balanced trees is " + (countBalanced/(double)numberTrees)*100 + "%");
    }
}
