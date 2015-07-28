.class Lcom/android/mail/ui/AnimatedAdapter$1;
.super Ljava/lang/Object;
.source "AnimatedAdapter.java"

# interfaces
.implements Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AnimatedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AnimatedAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/android/mail/ui/AnimatedAdapter$1;->this$0:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onListItemsRemoved()V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/android/mail/ui/AnimatedAdapter$1;->this$0:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 83
    return-void
.end method
