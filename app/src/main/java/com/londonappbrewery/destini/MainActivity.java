package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private StoryNode mCurrentNode;

    private StoryNode mRoot = new StoryNode(
            R.string.T1_Story,
            R.string.T1_Ans1,
            R.string.T1_Ans2,
            new StoryNode(
                    R.string.T3_Story,
                    R.string.T3_Ans1,
                    R.string.T3_Ans2,
                    new StoryNode(R.string.T6_End, 0, 0, null, null),
                    new StoryNode(R.string.T5_End, 0, 0, null, null)
            ),
            new StoryNode(
                    R.string.T2_Story,
                    R.string.T2_Ans1,
                    R.string.T2_Ans2,
                    new StoryNode(
                            R.string.T3_Story,
                            R.string.T3_Ans1,
                            R.string.T3_Ans2,
                            new StoryNode(R.string.T6_End, 0, 0, null, null),
                            new StoryNode(R.string.T5_End, 0, 0, null, null)
                    ),
                    new StoryNode(R.string.T4_End, 0, 0, null, null)
            )
    );

    private Button mRedButton;
    private Button mBlueButton;
    private TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRedButton = findViewById(R.id.buttonTop);
        mBlueButton = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        mCurrentNode = mRoot;

        mStoryTextView.setText(mCurrentNode.getStoryID());
        mRedButton.setText(mCurrentNode.getRedButtonID());
        mBlueButton.setText(mCurrentNode.getBlueButtonID());

        mRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mCurrentNode = mCurrentNode.getRedNode();
                mStoryTextView.setText(mCurrentNode.getStoryID());

                if(mCurrentNode.getRedNode() == null)
                {
                    GameOver();
                }
                else
                {
                    AdvanceStoryStep();
                }
            }
        });

        mBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mCurrentNode = mCurrentNode.getBlueNode();
                mStoryTextView.setText(mCurrentNode.getStoryID());

                if(mCurrentNode.getBlueNode() == null)
                {
                    GameOver();
                }
                else
                {
                    AdvanceStoryStep();
                }
            }
        });
    }

    private void GameOver()
    {
        ViewGroup layout = (ViewGroup) mRedButton.getParent();
        layout.removeView(mRedButton);
        layout.removeView(mBlueButton);
    }

    private void AdvanceStoryStep()
    {
        mRedButton.setText(mCurrentNode.getRedButtonID());
        mBlueButton.setText(mCurrentNode.getBlueButtonID());
    }
}
