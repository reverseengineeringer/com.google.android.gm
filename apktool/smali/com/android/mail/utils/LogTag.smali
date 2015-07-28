.class public Lcom/android/mail/utils/LogTag;
.super Ljava/lang/Object;
.source "LogTag.java"


# static fields
.field private static LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    const-string v0, "Gmail"

    sput-object v0, Lcom/android/mail/utils/LogTag;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    sget-object v0, Lcom/android/mail/utils/LogTag;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method
