.class Lcom/google/android/gm/LabelSettingsFragment$Pair;
.super Ljava/lang/Object;
.source "LabelSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/LabelSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Pair"
.end annotation


# instance fields
.field public key:I

.field public value:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "key"    # I
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 382
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 383
    iput p1, p0, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    .line 384
    iput-object p2, p0, Lcom/google/android/gm/LabelSettingsFragment$Pair;->value:Ljava/lang/String;

    .line 385
    return-void
.end method
