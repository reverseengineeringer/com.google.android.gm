.class public final Lcom/google/android/gms/common/ConnectionResult;
.super Ljava/lang/Object;
.source "ConnectionResult.java"


# static fields
.field public static final RESULT_SUCCESS:Lcom/google/android/gms/common/ConnectionResult;


# instance fields
.field private final mPendingIntent:Landroid/app/PendingIntent;

.field private final mStatusCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 99
    new-instance v0, Lcom/google/android/gms/common/ConnectionResult;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    sput-object v0, Lcom/google/android/gms/common/ConnectionResult;->RESULT_SUCCESS:Lcom/google/android/gms/common/ConnectionResult;

    return-void
.end method

.method public constructor <init>(ILandroid/app/PendingIntent;)V
    .locals 0
    .param p1, "statusCode"    # I
    .param p2, "pendingIntent"    # Landroid/app/PendingIntent;

    .prologue
    .line 110
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 111
    iput p1, p0, Lcom/google/android/gms/common/ConnectionResult;->mStatusCode:I

    .line 112
    iput-object p2, p0, Lcom/google/android/gms/common/ConnectionResult;->mPendingIntent:Landroid/app/PendingIntent;

    .line 113
    return-void
.end method


# virtual methods
.method public getErrorCode()I
    .locals 1

    .prologue
    .line 163
    iget v0, p0, Lcom/google/android/gms/common/ConnectionResult;->mStatusCode:I

    return v0
.end method
