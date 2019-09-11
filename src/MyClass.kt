class MyClass(var name:String) {


    fun echo(){


        val echoString = readLine()

        println(echoString+" "+name)

        /*

        val

        System.setIn(ByteArrayInputStream( name.toByteArray() ))
*/
        /*val baos = ByteArrayOutputStream()
        val old = System.out;
        val ps = PrintStream(baos);
        System.setOut(ps);


        System.out.flush();
        System.setOut(old);
        System.out.println(baos.toString());*/

    }
}