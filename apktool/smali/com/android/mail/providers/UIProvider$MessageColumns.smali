.class public final Lcom/android/mail/providers/UIProvider$MessageColumns;
.super Ljava/lang/Object;
.source "UIProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/UIProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MessageColumns"
.end annotation


# static fields
.field public static READ:Ljava/lang/String;

.field public static STARRED:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1456
    const-string v0, "read"

    sput-object v0, Lcom/android/mail/providers/UIProvider$MessageColumns;->READ:Ljava/lang/String;

    .line 1461
    const-string v0, "starred"

    sput-object v0, Lcom/android/mail/providers/UIProvider$MessageColumns;->STARRED:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 1513
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
