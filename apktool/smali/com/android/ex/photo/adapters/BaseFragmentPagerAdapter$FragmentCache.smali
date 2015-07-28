.class Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;
.super Landroid/util/LruCache;
.source "BaseFragmentPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FragmentCache"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/util/LruCache",
        "<",
        "Ljava/lang/String;",
        "Landroid/app/Fragment;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;


# direct methods
.method public constructor <init>(Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;I)V
    .locals 0
    .param p2, "size"    # I

    .prologue
    .line 175
    iput-object p1, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;->this$0:Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;

    .line 176
    invoke-direct {p0, p2}, Landroid/util/LruCache;-><init>(I)V

    .line 177
    return-void
.end method


# virtual methods
.method protected bridge synthetic entryRemoved(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Z
    .param p2, "x1"    # Ljava/lang/Object;
    .param p3, "x2"    # Ljava/lang/Object;
    .param p4, "x3"    # Ljava/lang/Object;

    .prologue
    .line 174
    check-cast p2, Ljava/lang/String;

    .end local p2    # "x1":Ljava/lang/Object;
    check-cast p3, Landroid/app/Fragment;

    .end local p3    # "x2":Ljava/lang/Object;
    check-cast p4, Landroid/app/Fragment;

    .end local p4    # "x3":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;->entryRemoved(ZLjava/lang/String;Landroid/app/Fragment;Landroid/app/Fragment;)V

    return-void
.end method

.method protected entryRemoved(ZLjava/lang/String;Landroid/app/Fragment;Landroid/app/Fragment;)V
    .locals 1
    .param p1, "evicted"    # Z
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "oldValue"    # Landroid/app/Fragment;
    .param p4, "newValue"    # Landroid/app/Fragment;

    .prologue
    .line 183
    if-nez p1, :cond_0

    if-eqz p4, :cond_1

    if-eq p3, p4, :cond_1

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;->this$0:Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;

    # getter for: Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;
    invoke-static {v0}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->access$000(Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 186
    :cond_1
    return-void
.end method
