package hello.advanced.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs; // 종료 시 시작 시간과 계산하여 시간 계산
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
