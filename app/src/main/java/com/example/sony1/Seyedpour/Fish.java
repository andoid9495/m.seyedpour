package com.example.sony1.Seyedpour;

/**
 * Created by SONY1 on 7/25/2015.
 */
public class Fish {
    public String fishName;
    public int imageResource;
    public String instructions;

    public Fish(String id, int imageResource, String instructions)
    {
        this.fishName=id;
        this.imageResource=imageResource;
        this.instructions=instructions;
    }
    @Override
    public String toString()
    {
        return fishName;
    }
}
