/*
    The argument x which is passed into the operator class is used to represent the value we initially
    enter into the calculator. This means that the user can enter the value (i.e. 9) and that value will be
    stored but until an operation and another value is provided
 */
sealed class Operator(val x: Long) {
    abstract fun calculate(y: Long): Long

    /*
        Class to perform the addition function in the calculator
     */
    class add(x: Long) : Operator(x){

        override fun calculate(y: Long): Long {
            return x + y
        }
    }

    // Subtraction
    class sub(x: Long) : Operator(x){

        override fun calculate(y: Long): Long {
            return x - y
        }
    }

    // Multiplication
    class mult(x: Long) : Operator(x){

        override fun calculate(y: Long): Long {
            return x * y
        }
    }

    // Division
    class div(x: Long) : Operator(x){

        override fun calculate(y: Long): Long {
            return x / y
        }
    }
}