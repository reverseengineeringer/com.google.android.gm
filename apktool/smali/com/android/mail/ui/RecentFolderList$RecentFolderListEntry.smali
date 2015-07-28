.class Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;
.super Ljava/lang/Object;
.source "RecentFolderList.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/RecentFolderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RecentFolderListEntry"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;",
        ">;"
    }
.end annotation


# static fields
.field private static final SEQUENCE_GENERATOR:Ljava/util/concurrent/atomic/AtomicInteger;


# instance fields
.field private final mFolder:Lcom/android/mail/providers/Folder;

.field private final mSequence:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 245
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    sput-object v0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->SEQUENCE_GENERATOR:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method

.method constructor <init>(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 250
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 251
    iput-object p1, p0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->mFolder:Lcom/android/mail/providers/Folder;

    .line 252
    sget-object v0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->SEQUENCE_GENERATOR:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->mSequence:I

    .line 253
    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;)Lcom/android/mail/providers/Folder;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->mFolder:Lcom/android/mail/providers/Folder;

    return-object v0
.end method


# virtual methods
.method public compareTo(Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;)I
    .locals 2
    .param p1, "t"    # Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;

    .prologue
    .line 261
    iget v0, p1, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->mSequence:I

    iget v1, p0, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->mSequence:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 244
    check-cast p1, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;->compareTo(Lcom/android/mail/ui/RecentFolderList$RecentFolderListEntry;)I

    move-result v0

    return v0
.end method
