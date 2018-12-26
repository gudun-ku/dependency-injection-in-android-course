package com.techyourchance.journeytodependencyinjection.screens.questiondetails;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.techyourchance.journeytodependencyinjection.R;
import com.techyourchance.journeytodependencyinjection.networking.ImageLoader;
import com.techyourchance.journeytodependencyinjection.questions.QuestionDetails;
import com.techyourchance.journeytodependencyinjection.questions.QuestionOwner;
import com.techyourchance.journeytodependencyinjection.screens.common.mvcviews.BaseViewMvc;

import us.feras.mdv.MarkdownView;

public class QuestionDetailsViewMvcImpl extends BaseViewMvc<QuestionDetailsViewMvc.Listener>
        implements QuestionDetailsViewMvc {
    private final ImageLoader mImageLoader;
    private final MarkdownView markdownView;
    private final TextView mTxtUserDisplayName;
    private final ImageView mImgUserAvatar;

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup container, ImageLoader imageLoader) {

        mImageLoader = imageLoader;

        setRootView(inflater.inflate(R.layout.layout_question_details, container, false));

        markdownView = findViewById(R.id.markdownView);

        mTxtUserDisplayName = findViewById(R.id.txt_user_display_name);
        mImgUserAvatar = findViewById(R.id.img_user_avatar);
    }

    @Override
    public void bindQuestion(QuestionDetails question) {
        String questionBody = question.getBody();
        String questionBodyMarkdown = question.getBodyMarkdown();

        markdownView.loadMarkdown(questionBodyMarkdown);

        String userDisplayName = null;
        String userAvatarUrl = null;
        QuestionOwner owner = question.getOwner();
        if (owner != null && owner instanceof QuestionOwner) {
            userDisplayName = question.getOwner().getUserDisplayName();
            userAvatarUrl = question.getOwner().getUserAvatarUrl();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                mTxtUserDisplayName.setText(Html.fromHtml(userDisplayName,Html.FROM_HTML_MODE_LEGACY));
            } else {
                mTxtUserDisplayName.setText(Html.fromHtml(userDisplayName));
            }
            mImageLoader.loadImage(userAvatarUrl, mImgUserAvatar);
        }
    }
}
