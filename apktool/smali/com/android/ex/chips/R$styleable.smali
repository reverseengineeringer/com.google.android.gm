.class public final Lcom/android/ex/chips/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/chips/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final FancySummaryListPreference:[I

.field public static final MultiAdapterSpinner:[I

.field public static final RecipientEditTextView:[I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 3027
    new-array v0, v3, [I

    const v1, 0x7f010009

    aput v1, v0, v2

    sput-object v0, Lcom/android/ex/chips/R$styleable;->FancySummaryListPreference:[I

    .line 3050
    new-array v0, v3, [I

    const v1, 0x7f010008

    aput v1, v0, v2

    sput-object v0, Lcom/android/ex/chips/R$styleable;->MultiAdapterSpinner:[I

    .line 3087
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/android/ex/chips/R$styleable;->RecipientEditTextView:[I

    return-void

    :array_0
    .array-data 4
        0x7f010000
        0x7f010001
        0x7f010002
        0x7f010003
        0x7f010004
        0x7f010005
        0x7f010006
        0x7f010007
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3016
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
