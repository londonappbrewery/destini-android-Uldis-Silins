package com.londonappbrewery.destini;

public class StoryNode
{
    private int mStoryID;
    private int mRedButtonID;
    private int mBlueButtonID;
    private StoryNode mRedNode;
    private StoryNode mBlueNode;

    public StoryNode(int storyId, int redButtonID, int blueButtonID, StoryNode redNode, StoryNode blueNode)
    {
        mStoryID = storyId;
        mRedButtonID = redButtonID;
        mBlueButtonID = blueButtonID;
        mRedNode = redNode;
        mBlueNode = blueNode;
    }

    public int getStoryID()
    {
        return mStoryID;
    }

    public void setStoryID(int storyID)
    {
        mStoryID = storyID;
    }

    public int getRedButtonID()
    {
        return mRedButtonID;
    }

    public void setRedButtonID(int redButtonID)
    {
        mRedButtonID = redButtonID;
    }

    public int getBlueButtonID()
    {
        return mBlueButtonID;
    }

    public void setBlueButtonID(int blueButtonID)
    {
        mBlueButtonID = blueButtonID;
    }

    public StoryNode getRedNode()
    {
        return mRedNode;
    }

    public void setRedNode(StoryNode redNode)
    {
        mRedNode = redNode;
    }

    public StoryNode getBlueNode()
    {
        return mBlueNode;
    }

    public void setBlueNode(StoryNode blueNode)
    {
        mBlueNode = blueNode;
    }
}
