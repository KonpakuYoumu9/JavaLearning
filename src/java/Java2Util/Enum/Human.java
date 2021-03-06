package Java2Util.Enum;

import org.junit.Test;

/***Created by moyongzhuo
 *On 2018/5/10  ***11:00.
 ******/
public class Human{
    public void sing(HumanState state){
        switch (state)
        {
            case HAPPY:
                singHappySong();
                break;
            case SAD:
                singDirge();
                break;
            default:
                new IllegalStateException("Invalid State: " + state);
        }
    }
    private void singHappySong(){
        System.out.println("When you're happy and you know it ...");
    }
    private void singDirge(){
        System.out.println("Don't cry for me Argentina, ...");
    }
    @Test
    public void test(){
        HumanState stste = HumanState.HAPPY;
        sing(stste);

    }
}