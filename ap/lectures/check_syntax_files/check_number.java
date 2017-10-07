class Example7{
  static int var1;
  static String var2;
  //Its a Static Method
  public void lala() 
  {
      System.out.println("Var1 is:"+var1);
      System.out.println("Var2 is:"+var2);
  }
  public static void main(String args[])
  {
  	Example7 e = new Example7();
  	e.lala();
  }
}