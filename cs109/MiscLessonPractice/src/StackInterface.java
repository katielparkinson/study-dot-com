package MiscLessonPractice.src;
public interface StackInterface{
            //add a plate to the stack
            void push(int plate);
            //remove a plate from the stack
            int pop();
            //look at the plate on the top of the stack
            int peek();
            //how many plates are in the stack?
            int size();
            //are all of the plates clean?
            boolean isEmpty();
    }
