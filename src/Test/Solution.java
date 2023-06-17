package Test;



interface Expression {}

//Example  column > value  column is left, > is operator, value is right
class Condition implements Expression {
    String left, right;
    String operator;
    Condition(String left, String operator, String right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}

//Example :- (column1 > vaue1) and (column2 < value2) and (column3 != value3)  here args = (column1 > vaue1),(column2 < vaue2),(column3 != vaue3)
// operator = and
class Clause implements Expression {
    Expression[] args;
    String operator;

    Clause(Expression[] args, String operator) {
        this.args = args;
        this.operator = operator;
    }
}

class Solution {

    //compare expressions and return true if both are same,
    static boolean compareExpressions(Expression expression1, Expression expression2) {

        if(expression1.getClass() != expression2.getClass())
            return false;
        if(expression1 instanceof Condition && expression2 instanceof Condition) {
            Condition cond1 = (Condition) expression1;
            Condition cond2 = (Condition) expression2;

            if(null == cond1 || null == cond1.left || null == cond1.right || null == cond1.operator ||
                null == cond2 ||null == cond2.left || null == cond2.right || null == cond2.operator)
                return false;
            return  cond1.left.equals(cond2.left) &&
                    cond1.operator.equals(cond2.operator) &&
                    cond1.right.equals(cond2.right);
        }
        if(expression1 instanceof Clause && expression2 instanceof Clause){
            Clause clause1 = (Clause) expression1;
            Clause clause2 = (Clause) expression2;
            if(!clause1.operator.equals(clause2.operator))
                return false;
            Expression[] args1 = clause1.args;
            Expression[] args2 = clause2.args;
            if(args1.length != args2.length)
                return false;
            for(int i=0;i< args1.length;i++){
                 if(!compareExpressions(args1[i],args2[i]))
                     return false;
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        //Case 1  => true
        boolean ans = compareExpressions( new Condition("column1" , ">", "vaue1"), new Condition("column1" , ">", "vaue1"));
        System.out.println(ans);
        Expression[] e1 = new Expression[]{new Condition("a" , ">", "b"), new Condition("c" , "<", "d")};
        Expression[] e2 = new Expression[]{new Condition("a" , ">", "b"), new Condition("c" , "<", "d")};

        Clause clause1 = new Clause(e1, "and");
        Clause clause2 = new Clause(e2, "and");
        //Case 2 true
        System.out.println(compareExpressions(clause1, clause2));

    }

}