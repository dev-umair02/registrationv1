public  class A{
    public static void main(String[] args) {

                int[] numbers = {10, 20,30};

                // Bug: Accessing an element beyond the array size
                System.out.println("Fourth Element: " + numbers[2]);
            }
    }
