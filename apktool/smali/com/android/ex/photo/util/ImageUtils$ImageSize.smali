.class public final enum Lcom/android/ex/photo/util/ImageUtils$ImageSize;
.super Ljava/lang/Enum;
.source "ImageUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/photo/util/ImageUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ImageSize"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/ex/photo/util/ImageUtils$ImageSize;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/ex/photo/util/ImageUtils$ImageSize;

.field public static final enum EXTRA_SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

.field public static final enum NORMAL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

.field public static final enum SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 52
    new-instance v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    const-string v1, "EXTRA_SMALL"

    invoke-direct {v0, v1, v2}, Lcom/android/ex/photo/util/ImageUtils$ImageSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->EXTRA_SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    .line 53
    new-instance v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    const-string v1, "SMALL"

    invoke-direct {v0, v1, v3}, Lcom/android/ex/photo/util/ImageUtils$ImageSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    .line 54
    new-instance v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    const-string v1, "NORMAL"

    invoke-direct {v0, v1, v4}, Lcom/android/ex/photo/util/ImageUtils$ImageSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->NORMAL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    .line 51
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    sget-object v1, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->EXTRA_SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    aput-object v1, v0, v2

    sget-object v1, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->SMALL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->NORMAL:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    aput-object v1, v0, v4

    sput-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->$VALUES:[Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    return-object v0
.end method

.method public static values()[Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->$VALUES:[Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    invoke-virtual {v0}, [Lcom/android/ex/photo/util/ImageUtils$ImageSize;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    return-object v0
.end method
