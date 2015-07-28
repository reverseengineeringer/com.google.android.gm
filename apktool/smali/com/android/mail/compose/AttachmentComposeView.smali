.class Lcom/android/mail/compose/AttachmentComposeView;
.super Landroid/widget/LinearLayout;
.source "AttachmentComposeView.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mAttachment:Lcom/android/mail/providers/Attachment;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/compose/AttachmentComposeView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Attachment;)V
    .locals 7
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 43
    iput-object p2, p0, Lcom/android/mail/compose/AttachmentComposeView;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 45
    sget-object v3, Lcom/android/mail/compose/AttachmentComposeView;->LOG_TAG:Ljava/lang/String;

    const/4 v4, 0x3

    invoke-static {v3, v4}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 46
    const/4 v0, 0x0

    .line 48
    .local v0, "attachStr":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p2}, Lcom/android/mail/providers/Attachment;->toJSON()Lorg/json/JSONObject;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 52
    :goto_0
    sget-object v3, Lcom/android/mail/compose/AttachmentComposeView;->LOG_TAG:Ljava/lang/String;

    const-string v4, "attachment view: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 55
    .end local v0    # "attachStr":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentComposeView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 57
    .local v2, "factory":Landroid/view/LayoutInflater;
    const v3, 0x7f04000f

    invoke-virtual {v2, v3, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 58
    invoke-direct {p0, p1}, Lcom/android/mail/compose/AttachmentComposeView;->populateAttachmentData(Landroid/content/Context;)V

    .line 59
    return-void

    .line 49
    .end local v2    # "factory":Landroid/view/LayoutInflater;
    .restart local v0    # "attachStr":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 50
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {p2}, Lcom/android/mail/providers/Attachment;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private populateAttachmentData(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const v2, 0x7f10002f

    .line 67
    const v0, 0x7f100004

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/AttachmentComposeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/compose/AttachmentComposeView;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v1, v1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentComposeView;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v0, v0, Lcom/android/mail/providers/Attachment;->size:I

    if-lez v0, :cond_0

    .line 70
    invoke-virtual {p0, v2}, Lcom/android/mail/compose/AttachmentComposeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/android/mail/compose/AttachmentComposeView;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v1, v1, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v1, v1

    invoke-static {p1, v1, v2}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 75
    :goto_0
    return-void

    .line 73
    :cond_0
    invoke-virtual {p0, v2}, Lcom/android/mail/compose/AttachmentComposeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public addDeleteListener(Landroid/view/View$OnClickListener;)V
    .locals 2
    .param p1, "clickListener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 62
    const v1, 0x7f100030

    invoke-virtual {p0, v1}, Lcom/android/mail/compose/AttachmentComposeView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 63
    .local v0, "deleteButton":Landroid/widget/ImageButton;
    invoke-virtual {v0, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    return-void
.end method
