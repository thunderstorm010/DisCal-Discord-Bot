package org.dreamexposure.discal.web.spring;

import org.dreamexposure.discal.web.handler.DiscordAccountHandler;
import org.dreamexposure.discal.web.network.discal.StatusHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
public class SpringController {

    //Main pages
    @RequestMapping({"/", "/home"})
    public String home(final Map<String, Object> model, final HttpServletRequest req) {
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "index";
    }

    @RequestMapping("/about")
    public String about(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "various/about";
    }

    @RequestMapping("/commands")
    public String commands(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "various/commands";
    }

    @RequestMapping("/lazy-discal")
    public String lazyDisCal(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "various/lazy-discal";
    }

    @RequestMapping("/setup")
    public String setup(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "various/setup";
    }

    //Policy pages
    @RequestMapping("/policy/privacy")
    public String privacyPolicy(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "policy/privacy";
    }

    @RequestMapping("/policy/tos")
    public String termsOfService(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "policy/tos";
    }

    //Account pages
    @RequestMapping("/login")
    public String accountLogin(final Map<String, Object> model, final HttpServletRequest req) {
        if (DiscordAccountHandler.getHandler().hasAccount(req))
            return "redirect:/dashboard";
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "account/login";
    }

    //Dashboard pages
    @RequestMapping("/dashboard")
    public String dashboard(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "dashboard/dashboard";
    }

    @RequestMapping("/dashboard/{id}")
    public String dashboardGuild(final Map<String, Object> model, final HttpServletRequest req, @PathVariable final String id) {
        if (!DiscordAccountHandler.getHandler().hasAccount(req))
            return "redirect:/dashboard";
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "dashboard/guild";
    }

    @RequestMapping("/dashboard/{id}/calendar")
    public String dashboardCalendar(final Map<String, Object> model, final HttpServletRequest req, @PathVariable final String id) {
        if (!DiscordAccountHandler.getHandler().hasAccount(req))
            return "redirect:/dashboard";
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "dashboard/calendar";
    }

    //Random Docs pages
    @RequestMapping("/docs/event/colors")
    public String docsEventsEventColors(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/event/event-colors";
    }

    //API Doc pages
    @RequestMapping("/docs/api/overview")
    public String docsApiOverview(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/overview";
    }

    @RequestMapping("/docs/api/errors")
    public String docsApiErrors(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/errors";
    }

    //API v1 doc pages
    @RequestMapping("/docs/api/v1/announcement")
    public String docsApiV1Announcement(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v1/announcement";
    }

    @RequestMapping("/docs/api/v1/calendar")
    public String docsApiV1Calendar(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v1/calendar";
    }

    @RequestMapping("/docs/api/v1/events")
    public String docsApiV1Events(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v1/events";
    }

    @RequestMapping("/docs/api/v1/guild")
    public String docsApiV1Guild(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v1/guild";
    }

    @RequestMapping("/docs/api/v1/rsvp")
    public String docsApiV1Rsvp(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v1/rsvp";
    }

    //API v2 doc pages
    @RequestMapping("/docs/api/v2/announcement")
    public String docsApiV2Announcement(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/announcement";
    }

    @RequestMapping("/docs/api/v2/calendar")
    public String docsApiV2Calendar(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/calendar";
    }

    @RequestMapping("/docs/api/v2/events")
    public String docsApiV2Events(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/events";
    }

    @RequestMapping("/docs/api/v2/guild")
    public String docsApiV2Guild(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/guild";
    }

    @RequestMapping("/docs/api/v2/rsvp")
    public String docsApiV2Rsvp(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/rsvp";
    }

    @RequestMapping("/docs/api/v2/status")
    public String docsApiV2Status(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "docs/api/v2/status";
    }

    //Embed pages
    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping("/embed/calendar/{id}")
    public String embedCalendar(final Map<String, Object> model, final HttpServletRequest req, @PathVariable final String id) {
        //This is a deprecated URL, but we are just redirecting for backwards compat.
        return "redirect:/embed/" + id + "/calendar/1";
    }

    @RequestMapping("/embed/{id}/calendar/{num}")
    public String embedCalendarWithNum(final Map<String, Object> model, final HttpServletRequest req, @PathVariable final String id, @PathVariable final String num) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getEmbedAccount(req));
        return "embed/calendar";
    }

    @RequestMapping("/status")
    public String status(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));

        //Just add status info here so we don't need to use JS for the status page.
        model.remove("status");
        model.put("status", StatusHandler.getLatestStatusInfo());

        return "various/status";
    }

    //Error pages - I actually reference this so need the mapping here
    @RequestMapping("/400")
    public String badRequest(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "error/400";
    }

    @RequestMapping("/404")
    public String notFound(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "error/404";
    }

    @RequestMapping("/500")
    public String internalError(final Map<String, Object> model, final HttpServletRequest req) {
        model.clear();
        model.putAll(DiscordAccountHandler.getHandler().getAccount(req));
        return "error/500";
    }
}