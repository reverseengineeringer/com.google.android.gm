.class Lcom/google/android/gm/provider/Gmail$LabelMap$1;
.super Ljava/lang/Object;
.source "Gmail.java"

# interfaces
.implements Ljava/util/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/Gmail$LabelMap;->init(Landroid/database/Cursor;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/Gmail$LabelMap;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/Gmail$LabelMap;)V
    .locals 0

    .prologue
    .line 2237
    iput-object p1, p0, Lcom/google/android/gm/provider/Gmail$LabelMap$1;->this$0:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public update(Ljava/util/Observable;Ljava/lang/Object;)V
    .locals 1
    .param p1, "observable"    # Ljava/util/Observable;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 2239
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap$1;->this$0:Lcom/google/android/gm/provider/Gmail$LabelMap;

    # invokes: Lcom/google/android/gm/provider/Gmail$LabelMap;->updateDataStructures()V
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->access$1100(Lcom/google/android/gm/provider/Gmail$LabelMap;)V

    .line 2240
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap$1;->this$0:Lcom/google/android/gm/provider/Gmail$LabelMap;

    # invokes: Lcom/google/android/gm/provider/Gmail$LabelMap;->setChanged()V
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->access$1200(Lcom/google/android/gm/provider/Gmail$LabelMap;)V

    .line 2241
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap$1;->this$0:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->notifyObservers()V

    .line 2242
    return-void
.end method
