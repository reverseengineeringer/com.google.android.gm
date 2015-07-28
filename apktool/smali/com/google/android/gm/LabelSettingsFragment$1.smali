.class Lcom/google/android/gm/LabelSettingsFragment$1;
.super Ljava/lang/Object;
.source "LabelSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/LabelSettingsFragment;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/LabelSettingsFragment;


# direct methods
.method constructor <init>(Lcom/google/android/gm/LabelSettingsFragment;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/google/android/gm/LabelSettingsFragment$1;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 184
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 185
    return-void
.end method
