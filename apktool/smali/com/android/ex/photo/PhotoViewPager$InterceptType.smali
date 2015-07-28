.class public final enum Lcom/android/ex/photo/PhotoViewPager$InterceptType;
.super Ljava/lang/Enum;
.source "PhotoViewPager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/photo/PhotoViewPager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "InterceptType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/ex/photo/PhotoViewPager$InterceptType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/ex/photo/PhotoViewPager$InterceptType;

.field public static final enum BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

.field public static final enum LEFT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

.field public static final enum NONE:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

.field public static final enum RIGHT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 35
    new-instance v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Lcom/android/ex/photo/PhotoViewPager$InterceptType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->NONE:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    new-instance v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    const-string v1, "LEFT"

    invoke-direct {v0, v1, v3}, Lcom/android/ex/photo/PhotoViewPager$InterceptType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->LEFT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    new-instance v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    const-string v1, "RIGHT"

    invoke-direct {v0, v1, v4}, Lcom/android/ex/photo/PhotoViewPager$InterceptType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->RIGHT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    new-instance v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    const-string v1, "BOTH"

    invoke-direct {v0, v1, v5}, Lcom/android/ex/photo/PhotoViewPager$InterceptType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    sget-object v1, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->NONE:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->LEFT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->RIGHT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->$VALUES:[Lcom/android/ex/photo/PhotoViewPager$InterceptType;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    return-object v0
.end method

.method public static values()[Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->$VALUES:[Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    invoke-virtual {v0}, [Lcom/android/ex/photo/PhotoViewPager$InterceptType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    return-object v0
.end method
