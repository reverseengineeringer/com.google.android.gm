.class Lcom/android/mail/ui/AbstractActivityController$6;
.super Lcom/android/mail/utils/ContentProviderTask$UpdateTask;
.source "AbstractActivityController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->starMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;)V
    .locals 0

    .prologue
    .line 1102
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$6;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct {p0}, Lcom/android/mail/utils/ContentProviderTask$UpdateTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected onPostExecute(Lcom/android/mail/utils/ContentProviderTask$Result;)V
    .locals 0
    .param p1, "result"    # Lcom/android/mail/utils/ContentProviderTask$Result;

    .prologue
    .line 1106
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 1102
    check-cast p1, Lcom/android/mail/utils/ContentProviderTask$Result;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController$6;->onPostExecute(Lcom/android/mail/utils/ContentProviderTask$Result;)V

    return-void
.end method
