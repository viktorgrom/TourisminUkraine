package com.example.tourisminukraine.Callback;

import com.example.tourisminukraine.model.CommentModel;

import java.util.List;

public interface ICommentCallbackListener {
    void onCommentLoadSuccess (List<CommentModel> commentModels);
    void onCommentLoadFailed (String message);
}
