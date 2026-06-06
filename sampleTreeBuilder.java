/*
                               1
                 ┌─────────────┴─────────────┐
                2                             3
          ┌──────┴──────┐              ┌──────┴──────┐
         4               5             6               7
      ┌──┴──┐        ┌──┴──┐       ┌──┴──┐        ┌──┴──┐
     8     9        10     11     12     13       14     15
    ┌┴┐   ┌┴┐      ┌┴┐    ┌┴┐    ┌┴┐    ┌┴┐      ┌┴┐    ┌┴┐
   16 17 18 19    20 21  22 23  24 25  26 27    28 29  30 31
*/

public class sampleTreeBuilder {

    public static TreeNode buildNaturalNumberTree() {

        TreeNode[] nodes = new TreeNode[32]; // index 1..31

        for (int i = 1; i <= 31; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 1; i <= 15; i++) {
            nodes[i].left = nodes[2 * i];
            nodes[i].right = nodes[2 * i + 1];
        }

        return nodes[1]; // root = node 1
    }
}
