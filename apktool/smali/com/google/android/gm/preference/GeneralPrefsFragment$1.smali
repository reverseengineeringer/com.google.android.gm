.class Lcom/google/android/gm/preference/GeneralPrefsFragment$1;
.super Landroid/os/AsyncTask;
.source "GeneralPrefsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/preference/GeneralPrefsFragment;->onClick(Landroid/content/DialogInterface;I)V
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
.field final synthetic this$0:Lcom/google/android/gm/preference/GeneralPrefsFragment;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/google/android/gm/preference/GeneralPrefsFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->this$0:Lcom/google/android/gm/preference/GeneralPrefsFragment;

    iput-object p2, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 184
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 187
    iget-object v2, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->val$context:Landroid/content/Context;

    const v3, 0x7f0c0012

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "authority":Ljava/lang/String;
    new-instance v1, Landroid/provider/SearchRecentSuggestions;

    iget-object v2, p0, Lcom/google/android/gm/preference/GeneralPrefsFragment$1;->val$context:Landroid/content/Context;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v0, v3}, Landroid/provider/SearchRecentSuggestions;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 192
    .local v1, "suggestions":Landroid/provider/SearchRecentSuggestions;
    invoke-virtual {v1}, Landroid/provider/SearchRecentSuggestions;->clearHistory()V

    .line 193
    const/4 v2, 0x0

    return-object v2
.end method
