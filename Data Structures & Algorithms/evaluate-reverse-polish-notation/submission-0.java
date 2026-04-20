class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "/" -> stack.push(a / b);
                    case "*" -> stack.push(a * b);
                    default -> throw new RuntimeException("invalid operation");
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
