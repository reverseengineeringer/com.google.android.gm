.class Lcom/google/android/gm/provider/MailEngine$8;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailCore$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/MailEngine;->initialize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0

    .prologue
    .line 1374
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$8;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConversationNewlyMatchesNotificationRequest(Lcom/google/android/gm/provider/MailCore$NotificationRequest;)V
    .locals 5
    .param p1, "notificationRequest"    # Lcom/google/android/gm/provider/MailCore$NotificationRequest;

    .prologue
    .line 1377
    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->getTagLabelId()J

    move-result-wide v0

    .line 1378
    .local v0, "notificationTagLabelId":J
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$8;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getNumUnreadConversations(J)I

    move-result v2

    if-eqz v2, :cond_0

    .line 1379
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$8;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$1300(Lcom/google/android/gm/provider/MailEngine;)Ljava/util/Map;

    move-result-object v2

    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->getLabelId()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1381
    :cond_0
    return-void
.end method

.method public onLabelsUpdated(Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1384
    .local p1, "updatedLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$8;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V
    invoke-static {v0, p1}, Lcom/google/android/gm/provider/MailEngine;->access$1400(Lcom/google/android/gm/provider/MailEngine;Ljava/util/Set;)V

    .line 1385
    return-void
.end method
