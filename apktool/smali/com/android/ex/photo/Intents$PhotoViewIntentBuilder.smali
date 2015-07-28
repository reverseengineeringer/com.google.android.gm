.class public Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
.super Ljava/lang/Object;
.source "Intents.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/photo/Intents;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PhotoViewIntentBuilder"
.end annotation


# instance fields
.field private final mIntent:Landroid/content/Intent;

.field private mPhotoIndex:Ljava/lang/Integer;

.field private mPhotosUri:Ljava/lang/String;

.field private mProjection:[Ljava/lang/String;

.field private mResolvedPhotoUri:Ljava/lang/String;

.field private mThumbnailUri:Ljava/lang/String;


# direct methods
.method private constructor <init>(Landroid/content/Context;Ljava/lang/Class;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 79
    .local p2, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 80
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1, p2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    .line 81
    return-void
.end method

.method synthetic constructor <init>(Landroid/content/Context;Ljava/lang/Class;Lcom/android/ex/photo/Intents$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Ljava/lang/Class;
    .param p3, "x2"    # Lcom/android/ex/photo/Intents$1;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public build()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 121
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 125
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotoIndex:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "photo_index"

    iget-object v2, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotoIndex:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 129
    :cond_0
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotosUri:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "photos_uri"

    iget-object v2, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotosUri:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 133
    :cond_1
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mResolvedPhotoUri:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 134
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "resolved_photo_uri"

    iget-object v2, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mResolvedPhotoUri:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 137
    :cond_2
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mProjection:[Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 138
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "projection"

    iget-object v2, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mProjection:[Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 141
    :cond_3
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mThumbnailUri:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 142
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    const-string v1, "thumbnail_uri"

    iget-object v2, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mThumbnailUri:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 145
    :cond_4
    iget-object v0, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mIntent:Landroid/content/Intent;

    return-object v0
.end method

.method public setPhotoIndex(Ljava/lang/Integer;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    .locals 0
    .param p1, "photoIndex"    # Ljava/lang/Integer;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotoIndex:Ljava/lang/Integer;

    .line 86
    return-object p0
.end method

.method public setPhotosUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    .locals 0
    .param p1, "photosUri"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mPhotosUri:Ljava/lang/String;

    .line 92
    return-object p0
.end method

.method public setProjection([Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    .locals 0
    .param p1, "projection"    # [Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mProjection:[Ljava/lang/String;

    .line 98
    return-object p0
.end method

.method public setResolvedPhotoUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    .locals 0
    .param p1, "resolvedPhotoUri"    # Ljava/lang/String;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mResolvedPhotoUri:Ljava/lang/String;

    .line 108
    return-object p0
.end method

.method public setThumbnailUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    .locals 0
    .param p1, "thumbnailUri"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->mThumbnailUri:Ljava/lang/String;

    .line 116
    return-object p0
.end method
