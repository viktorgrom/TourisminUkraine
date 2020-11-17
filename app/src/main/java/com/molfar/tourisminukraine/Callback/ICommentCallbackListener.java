package com.molfar.tourisminukraine.Callback;

import com.molfar.tourisminukraine.model.CommentModel;

import java.util.List;

public interface ICommentCallbackListener {
    void onCommentLoadSuccess (List<CommentModel> commentModels);
    void onCommentLoadFailed (String message);
}
