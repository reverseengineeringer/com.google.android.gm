.class public final Lcom/google/android/common/html/parser/HTML$Element;
.super Ljava/lang/Object;
.source "HTML.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/html/parser/HTML;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Element"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/common/html/parser/HTML$Element$Flow;
    }
.end annotation


# instance fields
.field private final breaksFlow:Z

.field private final empty:Z

.field private final flow:Lcom/google/android/common/html/parser/HTML$Element$Flow;

.field private final name:Ljava/lang/String;

.field private final optionalEndTag:Z

.field private final type:I


# direct methods
.method public constructor <init>(Ljava/lang/String;IZZZLcom/google/android/common/html/parser/HTML$Element$Flow;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # I
    .param p3, "empty"    # Z
    .param p4, "optionalEndTag"    # Z
    .param p5, "breaksFlow"    # Z
    .param p6, "flow"    # Lcom/google/android/common/html/parser/HTML$Element$Flow;

    .prologue
    .line 69
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 70
    const-string v0, "Element name can not be null"

    invoke-static {p1, v0}, Lcom/google/android/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    const-string v0, "Element flow can not be null"

    invoke-static {p6, v0}, Lcom/google/android/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    iput-object p1, p0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    .line 73
    iput p2, p0, Lcom/google/android/common/html/parser/HTML$Element;->type:I

    .line 74
    iput-boolean p3, p0, Lcom/google/android/common/html/parser/HTML$Element;->empty:Z

    .line 75
    iput-boolean p4, p0, Lcom/google/android/common/html/parser/HTML$Element;->optionalEndTag:Z

    .line 76
    iput-boolean p5, p0, Lcom/google/android/common/html/parser/HTML$Element;->breaksFlow:Z

    .line 77
    iput-object p6, p0, Lcom/google/android/common/html/parser/HTML$Element;->flow:Lcom/google/android/common/html/parser/HTML$Element$Flow;

    .line 78
    return-void
.end method


# virtual methods
.method public breaksFlow()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->breaksFlow:Z

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 131
    if-ne p1, p0, :cond_0

    .line 132
    const/4 v1, 0x1

    .line 138
    :goto_0
    return v1

    .line 134
    :cond_0
    instance-of v1, p1, Lcom/google/android/common/html/parser/HTML$Element;

    if-eqz v1, :cond_1

    move-object v0, p1

    .line 135
    check-cast v0, Lcom/google/android/common/html/parser/HTML$Element;

    .line 136
    .local v0, "that":Lcom/google/android/common/html/parser/HTML$Element;
    iget-object v1, p0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    iget-object v2, v0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0

    .line 138
    .end local v0    # "that":Lcom/google/android/common/html/parser/HTML$Element;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 95
    iget v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->type:I

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 100
    iget-boolean v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->empty:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/google/android/common/html/parser/HTML$Element;->name:Ljava/lang/String;

    return-object v0
.end method
