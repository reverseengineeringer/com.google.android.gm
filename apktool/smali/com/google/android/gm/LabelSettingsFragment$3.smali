.class Lcom/google/android/gm/LabelSettingsFragment$3;
.super Ljava/lang/Object;
.source "LabelSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/LabelSettingsFragment;->showVibrateSettingsDialog(Lcom/google/android/gm/LabelSettingsFragment$Pair;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/LabelSettingsFragment;

.field final synthetic val$item:Lcom/google/android/gm/LabelSettingsFragment$Pair;


# direct methods
.method constructor <init>(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$Pair;)V
    .locals 0

    .prologue
    .line 310
    iput-object p1, p0, Lcom/google/android/gm/LabelSettingsFragment$3;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    iput-object p2, p0, Lcom/google/android/gm/LabelSettingsFragment$3;->val$item:Lcom/google/android/gm/LabelSettingsFragment$Pair;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichItem"    # I

    .prologue
    .line 314
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$3;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment$3;->val$item:Lcom/google/android/gm/LabelSettingsFragment$Pair;

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment$3;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, p2

    # invokes: Lcom/google/android/gm/LabelSettingsFragment;->saveVibrateSetting(Lcom/google/android/gm/LabelSettingsFragment$Pair;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$800(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$Pair;Ljava/lang/String;)V

    .line 317
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 318
    return-void
.end method
