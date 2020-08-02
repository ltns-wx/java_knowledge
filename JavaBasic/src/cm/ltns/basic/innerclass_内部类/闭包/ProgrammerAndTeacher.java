package cm.ltns.basic.innerclass_内部类.闭包;

public class ProgrammerAndTeacher extends Programmer {

    public ProgrammerAndTeacher() {

    }

    public ProgrammerAndTeacher(String name) {
        super(name);
    }

    private void teach() {
        System.out.println(getName() + "教程在讲台上讲课");
    }

    private class Closure implements Teachable {

        @Override
        public void work() {
            teach();
        }
    }

    public Teachable getCallBackReference() {
        return new Closure();
    }

    public static void main(String[] args) {
        ProgrammerAndTeacher programmerAndTeacher = new ProgrammerAndTeacher("ltns");
        programmerAndTeacher.work();
        programmerAndTeacher.getCallBackReference().work();

    }

}
