package com.zyq;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void ABC()
    {
        int u[] = new int[]{1,2,3};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            set.add(list.get(i));
        }
        System.out.println(set);
    }
}
