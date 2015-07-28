.class public final Lcom/android/mail/providers/UIProvider$FolderColumns;
.super Ljava/lang/Object;
.source "UIProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/UIProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FolderColumns"
.end annotation


# static fields
.field public static CAPABILITIES:Ljava/lang/String;

.field public static HAS_CHILDREN:Ljava/lang/String;

.field public static SYNC_WINDOW:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 772
    const-string v0, "capabilities"

    sput-object v0, Lcom/android/mail/providers/UIProvider$FolderColumns;->CAPABILITIES:Ljava/lang/String;

    .line 777
    const-string v0, "hasChildren"

    sput-object v0, Lcom/android/mail/providers/UIProvider$FolderColumns;->HAS_CHILDREN:Ljava/lang/String;

    .line 781
    const-string v0, "syncWindow"

    sput-object v0, Lcom/android/mail/providers/UIProvider$FolderColumns;->SYNC_WINDOW:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 840
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
