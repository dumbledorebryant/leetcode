package pass;

import java.util.*;

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class Int extends Node{
    String val;
    public Int(String value){
        val = value;
    }
    @Override
    public int evaluate(){
        return Integer.valueOf(val);
    }
}

interface Operation{
    public int evaluate(int op1, int op2);
}

class Add implements Operation{
    @Override
    public int evaluate(int op1, int op2){
        return op1 + op2;
    }
}

class Sub implements Operation{
    @Override
    public int evaluate(int op1, int op2){
        return op1 - op2;
    }
}

class Mul implements Operation{
    @Override
    public int evaluate(int op1, int op2){
        return op1 * op2;
    }
}

class Div implements Operation{
    @Override
    public int evaluate(int op1, int op2){
        return op2 / op1;
    }
}
class OperatorNode extends Node {

    Node left;
    Node right;
    Operation operation;

    public OperatorNode(Operation operation, Node left, Node right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return this.operation.evaluate(this.left.evaluate(), this.right.evaluate());
    }
}

class TreeBuilder {
    Map<String, Operation> map = new HashMap<>();
    public TreeBuilder(){
        map.put("+", new Add());
        map.put("-", new Sub());
        map.put("*", new Mul());
        map.put("/", new Div());
    }
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (String str : postfix){
            if (!map.containsKey(str)){
                stack.addLast(new Int(str));
            }
            else {
                Operation op = map.get(str);
                Node op1 = stack.removeLast();
                Node op2 = stack.removeLast();
                stack.addLast(new OperatorNode(op, op1, op2));
            }
        }
        return stack.getLast();
    }

    public static void main(String[] args) {
        String[] postfix = {"3","4","+","2","*","7","/"};
        TreeBuilder tb = new TreeBuilder();
        System.out.println(tb.buildTree(postfix));
    }
};

