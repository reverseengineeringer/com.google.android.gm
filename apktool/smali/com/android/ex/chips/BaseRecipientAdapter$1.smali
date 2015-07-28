.class Lcom/android/ex/chips/BaseRecipientAdapter$1;
.super Landroid/os/AsyncTask;
.source "BaseRecipientAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/ex/chips/BaseRecipientAdapter;->fetchPhotoAsync(Lcom/android/ex/chips/RecipientEntry;Landroid/net/Uri;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/chips/BaseRecipientAdapter;

.field final synthetic val$entry:Lcom/android/ex/chips/RecipientEntry;

.field final synthetic val$photoThumbnailUri:Landroid/net/Uri;


# direct methods
.method constructor <init>(Lcom/android/ex/chips/BaseRecipientAdapter;Landroid/net/Uri;Lcom/android/ex/chips/RecipientEntry;)V
    .locals 0

    .prologue
    .line 745
    iput-object p1, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->this$0:Lcom/android/ex/chips/BaseRecipientAdapter;

    iput-object p2, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->val$photoThumbnailUri:Landroid/net/Uri;

    iput-object p3, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->val$entry:Lcom/android/ex/chips/RecipientEntry;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 745
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/ex/chips/BaseRecipientAdapter$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    .line 748
    iget-object v0, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->this$0:Lcom/android/ex/chips/BaseRecipientAdapter;

    # getter for: Lcom/android/ex/chips/BaseRecipientAdapter;->mContentResolver:Landroid/content/ContentResolver;
    invoke-static {v0}, Lcom/android/ex/chips/BaseRecipientAdapter;->access$500(Lcom/android/ex/chips/BaseRecipientAdapter;)Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->val$photoThumbnailUri:Landroid/net/Uri;

    sget-object v2, Lcom/android/ex/chips/BaseRecipientAdapter$PhotoQuery;->PROJECTION:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 750
    .local v7, "photoCursor":Landroid/database/Cursor;
    if-eqz v7, :cond_1

    .line 752
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 753
    const/4 v0, 0x0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v6

    .line 754
    .local v6, "photoBytes":[B
    iget-object v0, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->val$entry:Lcom/android/ex/chips/RecipientEntry;

    invoke-virtual {v0, v6}, Lcom/android/ex/chips/RecipientEntry;->setPhotoBytes([B)V

    .line 756
    iget-object v0, p0, Lcom/android/ex/chips/BaseRecipientAdapter$1;->this$0:Lcom/android/ex/chips/BaseRecipientAdapter;

    # getter for: Lcom/android/ex/chips/BaseRecipientAdapter;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/android/ex/chips/BaseRecipientAdapter;->access$1900(Lcom/android/ex/chips/BaseRecipientAdapter;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/ex/chips/BaseRecipientAdapter$1$1;

    invoke-direct {v1, p0, v6}, Lcom/android/ex/chips/BaseRecipientAdapter$1$1;-><init>(Lcom/android/ex/chips/BaseRecipientAdapter$1;[B)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 765
    .end local v6    # "photoBytes":[B
    :cond_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 768
    :cond_1
    return-object v3

    .line 765
    :catchall_0
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method
